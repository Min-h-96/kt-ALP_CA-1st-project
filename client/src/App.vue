<script setup>
import axios from "axios";
import { useRouter } from "vue-router";

axios.defaults.withCredentials = true;

const router = useRouter();

const checkLoginState = async () => {
  await axios.get("http://localhost:8080/api/session/user", {
    header: {
      "Context-Type": "application/json",
    },
  }).then(res => {
    console.log(res.status);
    console.log(res.data);
  }).catch(err => {
    router.replace("/login");
  })
}
checkLoginState();
</script>

<template>
  <router-view />
</template>

<style scoped></style>
