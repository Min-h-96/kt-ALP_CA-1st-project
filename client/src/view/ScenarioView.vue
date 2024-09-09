<script setup>
import axios from "axios";

import QuestionTableRow from "../components/QuestionTableRow.vue";

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
      console.log(res.data);

      questions.update(res.data);
    })
    .catch((err) => {});
};
loadQuestion();
</script>

<template>
  <div class="col-xl-8 col-lg-7 m-4">
    <p>Scenario List</p>
    <table class="table">
      <thead class="thead-dark">
        <tr>
          <th scope="col">No.</th>
          <th scope="col">content</th>
          <th scope="col">question_step</th>
          <th scope="col">pre_question_id</th>
        </tr>
      </thead>
      <tbody>
        <QuestionTableRow :questions="questions.data" />
      </tbody>
    </table>
  </div>
</template>

<style scoped></style>
