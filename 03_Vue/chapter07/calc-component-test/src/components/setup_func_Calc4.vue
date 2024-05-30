<script>
import { reactive, computed } from "vue";

export default {
  name: "Calc4",
  setup: function () {
    const state = reactive({ x: 10, y: 20 });
    const result = computed(() => {
      return state.x + state.y;
    });

    return { state, result };
  },
};
</script>

<template>
  <div>
    <h3>CALCULATION 4</h3>

    X: <input type="text" v-model.number="state.x" />
    <br />
    Y: <input type="text" v-model.number="state.y" />
    <br />
    <div>결과: {{ result }}</div>
  </div>
</template>
