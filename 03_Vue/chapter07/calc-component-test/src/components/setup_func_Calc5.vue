<!-- x -> 이전 값과 새로운 값 출력 -->

<script>
import { ref, watch } from "vue";

export default {
  name: "Calc5",
  setup: function () {
    const x = ref(0); //0으로 초기화
    const result = ref(0); //0으로 초기화

    watch(x, (current, old) => {
      console.log(`x 변경: ${old} => ${current}`);
      result.value = current * 2;
    });

    return { x, result };
  },
};
</script>

<template>
  <div>
    <h3>CALCULATION 5</h3>

    x: <input type="text" v-model.number="x" />
    <br />
    2배 결과: {{ result }}
  </div>
</template>
