import { reactive } from "vue";
import { chart } from "./chartData";

export const date = reactive({
  year: new Date().getFullYear(),
  month: new Date().getMonth() + 1,
  nextMonth() {
    const now = new Date();

    if (this.year == now.getFullYear() && this.month == now.getMonth() + 1) {
      return;
    }

    this.month += 1;
    if (this.month > 12) {
      this.year += 1;
      this.month = 1;
    }

    chart.updateData(this.year, this.month);
  },
  preMonth() {
    if (this.year == 2023 && this.month == 1) {
      return;
    }

    this.month -= 1;
    if (this.month < 1) {
      this.year -= 1;
      this.month = 12;
    }

    chart.updateData(this.year, this.month);
  },
});
