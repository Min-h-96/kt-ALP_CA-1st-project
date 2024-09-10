<script setup>
import axios from "axios";

import ScenarioTableRow from "../components/ScenarioTableRow.vue";

import { scenarios } from "../stores/scenarioData";

const loadScenario = async () => {
  await axios("http://localhost:8080/api/scenarios", {
    header: {
      "Context-Type": "application/json",
    },
  })
    .then((res) => {
      scenarios.update(res.data);
    })
    .catch((err) => {
      console.log(err);
    });
};
loadScenario();
</script>

<template>
  <div class="row">
    <div class="col-xl-8 col-lg-7 m-4">
      <p>Scenario List</p>
      <table class="table">
        <thead class="thead-dark">
          <tr>
            <th scope="col">No.</th>
            <th scope="col">chatbot</th>
            <th scope="col">title</th>
            <th scope="col">content</th>
            <th scope="col">createdAt</th>
            <th scope="col">detail</th>
            <th scope="col">delete</th>
          </tr>
        </thead>
        <tbody>
          <ScenarioTableRow :scenarios="scenarios.data" />
        </tbody>
      </table>
    </div>
  </div>
</template>

<style scoped>
.thead-primary {
  background-color: #4e73df !important;
}
</style>
