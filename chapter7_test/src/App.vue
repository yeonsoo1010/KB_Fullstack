<script>
import CheckboxItem from "./components/CheckboxItem.vue";

export default {
  name: "App",
  components: {CheckboxItem},
  data() { 
    return {
      idols: [
        { id: 1, name: "BTS", checked: true},
        { id: 2, name: "BlackPink", checked: false},
        { id: 3, name: "EXO", checked: false}
      ],
    };
  },
}
</script>

<template>
  <div>
    <ul>
      <CheckboxItem
      v-for="idol in idols"
      :key = "idol.id"
      :name = "idol.name"
      :checked = "idol.checked"></CheckboxItem>
    </ul>
  </div>
</template>