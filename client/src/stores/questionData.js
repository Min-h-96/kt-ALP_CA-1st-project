import { reactive } from "vue";
import Tree from "../stores/Tree";

export const questions = reactive({
  data: null,
  sort(data) {
    const root = new Tree(null);
    let cur = root;

    data.forEach((d) => {
      if (d.question_step == 0) {
        cur.insertNode(d);
        cur = root.children[0];
        return;
      }

      if (d.pre_question_id != cur.data.question_id) {
        cur = root.searchNode(d);
      }

      if (d.pre_question_id == cur.data.question_id) {
        cur.insertNode(d);
      }
    });

    this.data = root.children[0];
  },
});
