<script setup>
import Sidebar from "./Sidebar.vue";
import Topbar from "./Topbar.vue";
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