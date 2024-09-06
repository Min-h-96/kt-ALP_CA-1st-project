import { createWebHistory, createRouter } from "vue-router";

import MainView from "../view/MainView.vue";
import LoginView from "../view/LoginView.vue";
import ChartView from "../view/ChartView.vue";
import Outlet from "../components/Outlet.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: "/login", component: LoginView },
    { path: "/",
      component: Outlet,
      children: [
        {path: "", component: MainView},
        { path: "chart", component: ChartView }
    ] },
  ],
});

export default router;
