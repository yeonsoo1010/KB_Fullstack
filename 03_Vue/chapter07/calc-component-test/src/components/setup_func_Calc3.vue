<script>
import { reactive } from "vue";

export default {
  name: "Calc3",
  setup: function () {
    const state = reactive({ x: 10, y: 20, result: 30 });

    const calcAdd = () => {
      state.result = state.x + state.y;
    };

    return { state, calcAdd };
  },
};
</script>

<template>
  <div>
    <h3>CALCULATION 3</h3>
    X: <input type="text" v-model.number="state.x" />
    <br />
    Y: <input type="text" v-model.number="state.y" />
    <br />
    <button @click="calcAdd">계산</button>
    <div>결과: {{ state.result }}</div>
  </div>
</template>
