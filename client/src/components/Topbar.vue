<script setup>
import { user } from "../stores/userData";
</script>

<template>
  <nav
    class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow"
  >
    <!-- Topbar Navbar -->
    <ul class="navbar-nav ml-auto">
      <div class="topbar-divider d-none d-sm-block"></div>

      <!-- Nav Item - User Information -->
      <li class="nav-item dropdown no-arrow">
        <a
          class="nav-link dropdown-toggle"
          href="#"
          id="userDropdown"
          role="button"
          data-toggle="dropdown"
          aria-haspopup="true"
          aria-expanded="false"
        >
          <span class="mr-2 d-none d-lg-inline text-gray-600 small">{{
            user.user_id
          }}</span>
          <img
            class="img-profile rounded-circle"
            src="../assets/img/undraw_profile.svg"
          />
        </a>
      </li>
    </ul>
  </nav>
</template>

<style scoped></style>
