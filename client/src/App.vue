<script setup>
import axios from "axios";
import { useRouter } from "vue-router";
import { user } from "./stores/userData";

axios.defaults.withCredentials = true;

const router = useRouter();

const checkLoginState = async () => {
  await axios
    .get("http://localhost:8080/api/session/user", {
      header: {
        "Context-Type": "application/json",
      },
    })
    .then((res) => {
      console.log("로그인 여부 확인!");
      user.update(res.data.id);
    })
    .catch((err) => {
      router.replace("/login");
    });
};
checkLoginState();
</script>

<template>
  <router-view />
</template>

<style scoped></style>
