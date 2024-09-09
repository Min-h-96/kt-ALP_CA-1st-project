import { reactive } from "vue";
import axios from "axios";

export const chart = reactive({
  data: {
    labels: [],
    datasets: [
      {
        label: "질문 클릭 수",
        backgroundColor: "#f87979",
        data: [],
      },
    ],
  },
  async updateData(
    year = new Date().getFullYear(),
    month = new Date().getMonth() + 1
  ) {
    const labels = [];
    const datasets = [
      {
        label: "질문 클릭 수",
        backgroundColor: "#f87979",
        data: [],
      },
    ];

    const result = {
      labels: [],
      datasets: [],
    };

    await axios
      .get(`http://localhost:8080/api/click?year=${year}&month=${month}`, {
        header: {
          "Context-Type": "application/json",
        },
      })
      .then((res) => {
        res.data.forEach((d) => {
          labels.push("질문 " + d.question_id.toString());
          datasets[0].data.push(d.count);
        });

        result.labels = labels;
        result.datasets = datasets;

        this.data = result;
      })
      .catch((err) => {
        console.log(err);
      });
  },
});
