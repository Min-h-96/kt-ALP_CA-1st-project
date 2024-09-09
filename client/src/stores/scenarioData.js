import { reactive } from "vue";

export const scenarios = reactive({
  data: null,
  update(data) {
    this.data = data;
  },
});
