<script setup>
import axios from "axios";
axios.defaults.withCredentials = true;

import Sidebar from "./components/Sidebar.vue";
import Topbar from "./components/Topbar.vue";
</script>

<template>
  <div id="wrapper">
    <Sidebar />
    <div id="content-wrapper" class="d-flex flex-column">
      <div id="content">
        <Topbar />
        <router-view />
      </div>
    </div>
  </div>
</template>

<style scoped></style>
