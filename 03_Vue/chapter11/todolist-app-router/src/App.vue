<script setup>
import { reactive, computed, provide } from "vue";
import Header from "@/components/Header.vue";
import axios from "axios";

// 데이터 배열로 채우기 !
const states = reactive({
  todoList: [
    {
      id: "1",
      todo: "야구장 ",
      desc: "프로야구 경기도 봐야합니다.",
      done: false,
    },
    { id: "2", "todo ": "놀기 ", desc: "노는 것도 중요합니다.", done: false },
    {
      id: "3",
      todo: "Vue 학습 ",
      desc: "Vue 학습을 해야 합니다.",
      done: false,
    },
    {
      id: "4",
      todo: "ES6 공부 ",
      desc: "ES6 공부를 해야 합니다.",
      done: false,
    },
  ],
});

// const BASEURI = "/api/todos";
// const states = reactive({ todoList: [] });

// todoList 목록 조회

const addTodo = ({ todo, desc }) => {
  states.todoList.push({ id: newDate().getTime(), todo, desc, done: false });
};

const updateTodo = ({ id, todo, desc, done }) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  states.todoList[index] = { ...states.todoList[index], todo, desc, done };
};

const deleteTodo = (id) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  states.todoList.splice(index, 1);
};

const toggleDone = (id) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  states.todoList[index].done = !states.todoList[index].done;
};

// provide
provide(
  "todoList",
  computed(() => states.todoList)
);
provide("actions", {
  addTodo,
  deleteTodo,
  toggleDone,
  updateTodo,
});
</script>
