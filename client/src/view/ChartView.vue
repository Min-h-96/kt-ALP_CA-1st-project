<script setup>
import { onBeforeMount } from "vue";

import Chart from "../components/Chart.vue";

import { chart } from "../stores/chartData";

onBeforeMount(() => {
  chart.updateData();
});
</script>

<template>
  <div class="row">
    <div class="col-xl-8 col-lg-7">
      <div class="card shadow mb-4">
        <Chart :data="chart.data" />
      </div>
      <div class="d-flex">
        <button v-on:click="chart.updateData('hi')"><</button>
        <p>2024년 9월</p>
        <button v-on:click="chart.updateData('hi')">></button>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
