<script>
import CheckboxItem from "./components/icons/CheckboxItem.vue";

export default {
  name: "App",
  // 지역 컴포넌트
  components: { CheckboxItem },
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
    <h2>App 컴포넌트</h2>
    <hr />
    <ul>
      <CheckboxItem
        v-for="idol in idols"
        :key="idol.id"
        :name="idol.name"
        :checked="idol.checked"
      />
    </ul>
  </div>
</template>
