<script setup>
import { defineProps, onUpdated } from "vue";

const props = defineProps(["scenarios"]);

onUpdated(() => {
  console.log(props.scenarios[0]);
});
</script>

<template>
  <tr v-for="(scenario, index) in props.scenarios">
    <th scope="row">{{ index + 1 }}</th>
    <td>{{ scenario.chatbot_id }}</td>
    <td>{{ scenario.title }}</td>
    <td>{{ scenario.content }}</td>
    <td>{{ scenario.createdAt.substr(0, 10) }}</td>
    <td><button>mod</button></td>
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
