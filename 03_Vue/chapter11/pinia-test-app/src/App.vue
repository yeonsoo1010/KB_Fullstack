<script setup>
import { useTodoListStore } from "./stores/todoLIst.js";
import { ref, computed } from "vue";

const todo = ref("");

// store useTodoListStore 사용하기: todoList, "doneCount - computed 걸어주기(?)" / addTodo, deleteTodo, toggleDone
const todoListStore = useTodoListStore();
const { todoList, addTodo, deleteTodo, toggleDone } = todoListStore;
const doneCount = computed(() => todoListStore.doneCount);

// addTodo를 핸들러 상수로 - 핸들러로 안만들고 함수를 불러오는 것은 안되나?
const addTodoHandler = () => {
  addTodo(todo.value); // todo: 반응/다른 컴포넌트에서 쓰려면 props, provide, state로 전달하면서 써야 한다 -> 빈문자열로 리셋해주고 다시 받는 거는 알겠는데.
  todo.value = "";
};
</script>

<template>
  <div>
    <h2>TodoList 테스트(Composition API)</h2>
    <hr />

    할일 추가:
    <input type="text" v-model="todo" /> &nbsp;
    <!-- <button @click="addTodoHandler">추가</button> -->
    <button @click="addTodo(todo)">추가</button>
    <hr />

    <ul>
      <li v-for="todoItem in todoList">
        <span style="cursor: pointer" @click="toggleDone(todoItem.id)">
          {{ todoItem.todo }} {{ todoItem.done ? "(완료)" : "" }}
        </span>
        &nbsp;&nbsp;&nbsp;
        <button @click="deleteTodo(todoItem.id)">삭제</button>
      </li>
    </ul>

    <div>완료된 할일 수: {{ doneCount }}</div>
  </div>
</template>
