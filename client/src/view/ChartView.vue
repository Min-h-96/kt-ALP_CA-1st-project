<script setup>
import { onBeforeMount } from "vue";

import Chart from "../components/Chart.vue";

import { chart } from "../stores/chartData";
import { date } from "../stores/dateData";

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
        <button v-on:click="date.preMonth()"><</button>
        <p>{{ date.year }}년 {{ date.month }}월</p>
        <button v-on:click="date.nextMonth()">></button>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
