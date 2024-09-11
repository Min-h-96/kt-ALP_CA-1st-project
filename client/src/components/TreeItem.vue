<script setup>
import axios from "axios";
import { ref, computed, useTemplateRef } from "vue";

const props = defineProps({
  questions: Object,
});

const inputContent = useTemplateRef("input-content");

const isOpen = ref(false);
const isModify = ref(true);

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

const modifyContent = () => {
  isModify.value = !isModify.value;

  inputContent.value.value = props.questions.data.content;
};

const saveContent = async () => {
  props.questions.data.content = inputContent.value.value;

  if (props.questions.data.answer_id == undefined) {
    await axios
      .post(
        "http://localhost:8080/api/question",
        {
          ...props.questions.data,
        },
        {
          header: {
            "Context-Type": "application/json",
          },
        }
      )
      .then((res) => {})
      .catch((err) => {
        console.log(err);
      });
  } else {
    await axios
      .post(
        "http://localhost:8080/api/answer",
        {
          ...props.questions.data,
        },
        {
          header: {
            "Context-Type": "application/json",
          },
        }
      )
      .then((res) => {})
      .catch((err) => {
        console.log(err);
      });
  }

  isModify.value = !isModify.value;
};
</script>

<template>
  <li>
    <div :class="{ bold: isFolder }" @dblclick="changeType">
      <span
        v-show="!props.questions.data.answer_id"
        @click="toggle"
        v-if="isFolder"
      >
        [{{ isOpen ? "-" : "+" }}]
      </span>
      <span v-show="isModify">{{ questions.data.content }}</span>
      <input v-show="!isModify" ref="input-content" />
      <span>
        <button v-show="isModify" v-on:click="modifyContent" type="button">
          수정
        </button>
        <button v-show="!isModify" v-on:click="saveContent" type="button">
          저장
        </button>
      </span>
    </div>
    <ul v-show="isOpen" v-if="isFolder">
      <TreeItem
        class="item"
        v-for="question in questions.children"
        :questions="question"
      >
      </TreeItem>
      <li v-show="props.questions.data.answer_id" class="add" @click="addChild">
        추가
      </li>
    </ul>
  </li>
</template>

<style scoped>
button {
  background-color: white;
  border-radius: 10%;
  font-size: 0.9rem;
  margin-left: 0.25rem;
}
</style>
