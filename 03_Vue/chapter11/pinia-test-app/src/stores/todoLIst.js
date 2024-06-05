import { defineStore } from "pinia";
import { reactive, computed } from "vue";

export const useTodoListStore = defineStore("todoList", () => {
  // 반응형 상태 state
  const state = reactive({
    todoList: [
      { id: 1, todo: "ES6 학습", done: false },
      { id: 2, todo: "React 학습", done: false },
      { id: 3, todo: "ContextAPI 학습", done: false },
      { id: 4, todo: "야구경기 관람", done: false },
    ],
  });

  // 액션 정의 action
  // action1: addTodo
  const addTodo = (todo) => {
    state.todoList.push({ id: new Date().getTime(), todo, done: false });
  };

  // action2: deleteTodo
  const deleteTodo = (id) => {
    let index = state.todoList.findIndex((todo) => todo.id === id);
    state.todoList.splice(index, 1); // index부터 1개 요소만 삭제!
  };

  // action3: toggleDone
  const toggleDone = (id) => {
    let index = state.todoList.findIndex((todo) => todo.id === id);
    state.todoList[index].done = !state.todoList[index].done;
  };

  // 상태1: doneCount
  const doneCount = computed(() => {
    return state.todoList.filter((x) => x.done === true).length;
  }); // todoItem = state.todoList 배열의 요소

  // 상태2: todoList
  const todoList = computed(() => state.todoList);

  return { todoList, doneCount, addTodo, deleteTodo, toggleDone };
});
