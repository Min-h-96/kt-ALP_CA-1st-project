<script setup>
import { defineProps } from "vue";

const props = defineProps(["questions"]);
</script>

<template>
  <tr v-for="(question, index) in props.questions">
    <th scope="row">{{ index + 1 }}</th>
    <td>{{ question.content }}</td>
    <td>{{ question.question_step }}</td>
    <td>{{ question.pre_question_id }}</td>
  </tr>
</template>

<style scoped></style>
