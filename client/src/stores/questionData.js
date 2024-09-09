import { reactive } from "vue";

export const questions = reactive({
  data: null,
  update(data) {
    this.data = data;
  },
});
