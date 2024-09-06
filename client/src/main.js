import { createApp } from "vue";

import "./reset.css";
import "./css/sb-admin-2.css";

import App from "./App.vue";
import router from "./router/router";

import BootstrapVue3 from 'bootstrap-vue-3'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'

createApp(App).use(BootstrapVue3).use(router).mount("#app");
