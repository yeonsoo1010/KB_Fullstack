<template>
  <div class="container">
    <Header />
    <router-view />
  </div>
</template>

<script setup>
import { reactive, computed, provide } from "vue";
import Header from "@/components/Header.vue";
import axios from "axios";

const BASEURI = "/api/todos";
const states = reactive({ todoList: [] });

// 데이터를 직접 연결!!
// const states = reactive({
//   todoList: [
//     { id: 1, todo: "ES6학습", desc: "설명1", done: false },
//     { id: 2, todo: "React학습", desc: "설명2", done: false },
//     { id: 3, todo: "ContextAPI 학습", desc: "설명3", done: true },
//     { id: 4, todo: "야구경기 관람", desc: "설명4", done: false },
//   ],
// });

// 1. TodoList 목록 조회
const fetchTodoList = async () => {
  try {
    const response = await axios.get(BASEURI);

    if (response.status === 200) {
      states.todoList = response.data;
    } else {
      alert("데이터 조회 실패");
    }
  } catch (error) {
    alert("에러발생: " + error);
  }
};

// const addTodo = ({ todo, desc }) => {
//   states.todoList.push({ id: new Date().getTime(), todo, desc, done: false });
// };

// const updateTodo = ({ id, todo, desc, done }) => {
//   let index = states.todoList.findIndex((todo) => todo.id === id);
//   states.todoList[index] = { ...states.todoList[index], todo, desc, done };
// };

// const deleteTodo = (id) => {
//   let index = states.todoList.findIndex((todo) => todo.id === id);
//   states.todoList.splice(index, 1);
// };

// const toggleDone = (id) => {
//   let index = states.todoList.findIndex((todo) => todo.id === id);
//   states.todoList[index].done = !states.todoList[index].done;
// };

// 2. addTodo
const addTodo = async ({ todo, desc }, successCallback) => {
  try {
    const payload = { todo, desc };
    const response = await axios.post(BASEURI, payload);
    if (response.status === 201) {
      states.todoList.push({ ...response.data, done: false });
      successCallback();
    } else {
      alert("Todo 추가 실패");
    }
  } catch (error) {
    alert("에러발생 :" + error);
  }
};

// 3. updateTodo
const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
  try {
    const payload = { id, todo, desc, done };
    const response = await axios.put(BASEURI + `/${id}`, payload);

    if (response.status === 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList[index] = payload;
      successCallback();
    } else {
      alert("Todo 변경 실패");
    }
  } catch (error) {
    alert("에러발생 :" + error);
  }
};

// 4. deleteTodo
const deleteTodo = async (id) => {
  try {
    const response = await axios.delete(BASEURI + `/${id}`);
    console.log(response.status, response.data);

    if (response.status === 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList.splice(index, 1);
    } else {
      alert("Todo 삭제 실패");
    }
  } catch (error) {
    alert("에러발생 :" + error);
  }
};

// 5. toggleDone
const toggleDone = async (id) => {
  try {
    let todo = states.todoList.find((todo) => todo.id === id);
    let payload = { ...todo, done: !todo.done };

    const response = await axios.put(BASEURI + `/${id}`, payload);

    if (response.status === 200) {
      todo.done = payload.done;
    } else {
      alert("Todo 완료 변경 실패");
    }
  } catch (error) {
    alert("에러발생 :" + error);
  }
};

//provide로 보내주기!!!
provide(
  "todoList",
  computed(() => states.todoList)
);
provide("actions", {
  addTodo,
  deleteTodo,
  toggleDone,
  updateTodo,
  fetchTodoList,
});

fetchTodoList();
</script>
