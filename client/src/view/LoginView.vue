<script setup>
import axios from "axios";
import { useRouter } from "vue-router";

const router = useRouter();

const body = {
  id: "bank",
  password: "1234",
};

const requestLogin = async () => {
  await axios
    .post("http://localhost:8080/api/login", body, {
      header: {
        "Context-Type": "application/json",
      },
    })
    .then((res) => {
      router.push("/");
    })
    .catch((res) => {
      console.log("실패");
    });
};
</script>

<template>
  <h1>로그인 페이지</h1>
  <p>아이디 : <input type="text" /></p>
  <p>비밀번호 : <input type="password" /></p>
  <button class="btn-login" type="button" v-on:click="requestLogin">
    로그인
  </button>
</template>

<style scoped>
.login-form {
  width: 18.75rem;
}
</style>
