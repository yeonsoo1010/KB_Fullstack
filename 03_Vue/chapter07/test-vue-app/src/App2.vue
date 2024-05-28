<script>
import CheckboxItem2 from "./components/icons/CheckboxItem2.vue";
export default {
  name: "App",
  components: { CheckboxItem2 },
  data() {
    return {
      idols: [
        { id: 1, name: "BTS", checked: true },
        { id: 2, name: "BLACKPINK", checked: false },
        { id: 3, name: "New Jeans", checked: false },
        { id: 4, name: "IVE", checked: false },
      ],
    };
  },
};
</script>

<template>
  <div>
    <h2>관심있는 K-POP 가수?</h2>
    <hr />
    <ul>
      <CheckboxItem2 v-for="idol in idols" :key="idol.id" :idol="idol" />
    </ul>
  </div>
</template>
