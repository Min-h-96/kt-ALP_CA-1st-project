<script setup>
import axios from "axios";

import QuestionTableRow from "../components/TreeItem.vue";

import { questions } from "../stores/questionData";

const pathname = window.location.pathname.split("/");
const scenario_id = pathname[pathname.length - 1];

const loadQuestion = async () => {
  await axios
    .get(`http://localhost:8080/api/question/${scenario_id}`, {
      header: {
        "Context-Type": "application/json",
      },
    })
    .then((res) => {
      questions.sort(res.data);
    })
    .catch((err) => {});
};
loadQuestion();
</script>

<template>
  <div class="col-xl-10 col-lg-7 m-4">
    <p>Scenario List</p>
    <ul v-if="questions.data">
      <QuestionTableRow :questions="questions.data" />
    </ul>
  </div>
</template>

<style scoped></style>
