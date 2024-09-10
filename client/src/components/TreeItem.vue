<script setup>
import { ref, computed } from "vue";

const props = defineProps({
  questions: Object,
});

const isOpen = ref(false);
const isFolder = computed(() => {
  return props.questions.children && props.questions.children.length;
});

function toggle() {
  isOpen.value = !isOpen.value;
}

function changeType() {
  if (!isFolder.value) {
    props.questions.children = [];
    addChild();
    isOpen.value = true;
  }
}

function addChild() {
  props.questions.children.push({ name: "new stuff" });
}
</script>

<template>
  <li>
    <div :class="{ bold: isFolder }" @click="toggle" @dblclick="changeType">
      {{ questions.data.content }}
      {{ console.log(questions.children) }}
      <span v-if="isFolder">[{{ isOpen ? "-" : "+" }}]</span>
    </div>
    <ul v-show="isOpen" v-if="isFolder">
      <TreeItem
        class="item"
        v-for="question in questions.children"
        :questions="question"
      >
      </TreeItem>
      <li class="add" @click="addChild">+</li>
    </ul>
  </li>
</template>
