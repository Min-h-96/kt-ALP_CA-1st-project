import { createWebHistory, createRouter } from "vue-router";

import MainView from "../view/MainView.vue";
import LoginView from "../view/LoginView.vue";
import ChartView from "../view/ChartView.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: "/", component: MainView },
    { path: "/login", component: LoginView },
    { path: "/chart", component: ChartView },
  ],
});

export default router;
