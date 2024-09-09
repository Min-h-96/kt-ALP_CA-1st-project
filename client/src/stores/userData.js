import { reactive } from "vue";

export const user = reactive({
  user_id: null,
  update(user_id) {
    this.user_id = user_id;
  },
});
