<script setup>
import axios from "axios";
axios.defaults.withCredentials = true;

import Sidebar from "./components/Sidebar.vue";
</script>

<template>
  <div id="wrapper">
    <Sidebar />
    <div id="content">
      <router-view />
    </div>
  </div>
</template>

<style scoped></style>
