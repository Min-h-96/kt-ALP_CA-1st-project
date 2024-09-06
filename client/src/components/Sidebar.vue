<script setup>
import axios from "axios";
import { useRouter } from "vue-router";

const router = useRouter();

const logout = async () => {
  await axios("http://localhost:8080/api/logout", {
    header: {
      "Context-Type": "application/json",
    },
  }).then(res => {
    router.replace('/login');
  })
};

</script>

<template>
  <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
      <div class="sidebar-brand-text mx-3">KT AICC Dashboard</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
      <a class="nav-link" href="/">
        <span>Dashboard</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
      Menu
    </div>

    <!-- Nav Item - Charts -->
    <li class="nav-item">
      <a class="nav-link" href="/chart"><span>Charts</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Heading -->
    <div v-on:click="logout" class="sidebar-heading">
      Logout
    </div>
  </ul>
</template>

<style scoped></style>
