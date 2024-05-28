<script>
export default {
  name: "InputName",

  // 유효성 검사
  emits: {
    nameChanged: (e) => {
      return e.name && typeof e.name === "string" && e.name.trim().length >= 3
        ? true
        : false;
    },
  },

  data() {
    return { name: "" };
  },
};
</script>

<template>
  <div>
    이름: <input type="text" v-model="name" />&nbsp
    <button @click="$emit('nameChanged', { name })">이벤트 발신</button>
  </div>
</template>
