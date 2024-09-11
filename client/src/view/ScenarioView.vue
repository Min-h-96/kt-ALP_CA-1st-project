<script setup>
import axios from "axios";

import QuestionTableRow from "../components/TreeItem.vue";

import { questions } from "../stores/questionData";

const pathname = window.location.pathname.split("/");
const scenario_id = pathname[pathname.length - 1];
let questionsData;
let answersData;

const loadData = async () => {
  await axios
    .get(`http://localhost:8080/api/question/${scenario_id}`, {
      header: {
        "Context-Type": "application/json",
      },
    })
    .then((res) => {
      questionsData = res.data;
    })
    .catch((err) => {});

  await axios
    .get(`http://localhost:8080/api/answer/${scenario_id}`, {
      header: {
        "Context-Type": "application/json",
      },
    })
    .then((res) => {
      answersData = res.data;
    })
    .catch((err) => {});

  questions.sort(questionsData, answersData);
};
loadData();
</script>

<template>
  <div class="col-xl-10 col-lg-7 m-4">
    <p>Question List</p>
    <ul v-if="questions.data">
      <QuestionTableRow :questions="questions.data" />
    </ul>
  </div>
</template>

<style scoped></style>
