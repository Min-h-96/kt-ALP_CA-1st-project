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
    <div class="col-xl-8 col-lg-7 m-4">
      <div class="d-flex center">
        <button v-on:click="date.preMonth()" class="btn-date"><</button>
        <p class="text-date">{{ date.year }}년 {{ date.month }}월</p>
        <button v-on:click="date.nextMonth()" class="btn-date">></button>
      </div>
      <div class="card shadow mb-4">
        <Chart :data="chart.data" />
      </div>
    </div>
  </div>
</template>

<style scoped>
.center {
  justify-content: center;
}

.btn-date {
  margin: 0.5rem;
  background-color: #8dc6ff;
  border: none;
  border-radius: 15%;
  color: azure;
}

.text-date {
  margin: 0;
  display: flex;
  align-items: center;
}
</style>
