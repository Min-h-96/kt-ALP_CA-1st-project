<script setup>
import axios from "axios";
import { useRouter } from "vue-router";
import { onBeforeMount, useTemplateRef } from "vue";

onBeforeMount(() => {
  const checkLoginState = async () => {
    await axios
      .get("http://localhost:8080/api/session/user", {
        header: {
          "Context-Type": "application/json",
        },
      })
      .then((res) => {
        router.replace("/");
      })
      .catch((err) => {});
  };
  checkLoginState();
});

const router = useRouter();
const id = useTemplateRef("input-id");
const password = useTemplateRef("input-password");

const requestLogin = async () => {
  await axios
    .post(
      "http://localhost:8080/api/login",
      {
        id: id.value.value,
        password: password.value.value,
      },
      {
        header: {
          "Context-Type": "application/json",
        },
      }
    )
    .then((res) => {
      router.push("/");
    })
    .catch((res) => {
      alert("아이디 또는 비밀번호가 잘못되었습니다.");
    });
};
</script>

<template>
  <div class="bg-gradient-primary h-100">
    <div class="container">
      <!-- Outer Row -->
      <div class="row justify-content-center">
        <div class="col-xl-10 col-lg-12 col-md-9">
          <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
              <!-- Nested Row within Card Body -->
              <div class="row">
                <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                <div class="col-lg-6">
                  <div class="p-5">
                    <div class="text-center">
                      <h1 class="h4 text-gray-900 mb-4">
                        Welcome KT AICC Manager!
                      </h1>
                    </div>
                    <form class="user">
                      <div class="form-group">
                        <input
                          type="text"
                          class="form-control form-control-user"
                          ref="input-id"
                          aria-describedby="emailHelp"
                          placeholder="Enter ID"
                        />
                      </div>
                      <div class="form-group">
                        <input
                          type="password"
                          class="form-control form-control-user"
                          ref="input-password"
                          placeholder="Enter Password"
                        />
                      </div>
                      <div class="form-group">
                        <div class="custom-control custom-checkbox small">
                          <input
                            type="checkbox"
                            class="custom-control-input"
                            id="customCheck"
                          />
                          <label class="custom-control-label" for="customCheck"
                            >Remember Me</label
                          >
                        </div>
                      </div>
                      <div
                        v-on:click="requestLogin"
                        class="btn btn-primary btn-user btn-block"
                      >
                        Login
                      </div>
                    </form>
                    <hr />
                    <div class="text-center">
                      <a class="small" href="#">Forgot Password?</a>
                    </div>
                    <div class="text-center">
                      <a class="small" href="#">Create an Account!</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.h-100 {
  height: 100vh !important;
}
</style>
