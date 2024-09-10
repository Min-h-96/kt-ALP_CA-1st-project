<script setup>
import { defineProps } from "vue";
import { useRouter } from "vue-router";

const props = defineProps(["scenarios"]);
const router = useRouter();

const toScenarioView = (id) => {
  router.replace({ name: "mod-scenario", params: { id: id } });
};
</script>

<template>
  <tr v-for="(scenario, index) in props.scenarios">
    <th scope="row">{{ index + 1 }}</th>
    <td>{{ scenario.chatbot_id }}</td>
    <td>{{ scenario.title }}</td>
    <td>{{ scenario.content }}</td>
    <td>{{ scenario.createdAt.substr(0, 10) }}</td>
    <td>
      <button v-on:click="toScenarioView(scenario.scenario_id)">detail</button>
    </td>
    <td><button>delete</button></td>
  </tr>
</template>

<style scoped>
td {
  max-width: 100%;
  white-space: nowrap;
}

button {
  border: none;
  background-color: #8dc5ff;
  color: azure;
  border-radius: 10%;
}
</style>
