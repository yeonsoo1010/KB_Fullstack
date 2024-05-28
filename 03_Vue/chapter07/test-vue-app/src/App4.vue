<script>
import InputName from "./components/InputName.vue";

export default {
  name: "App4",
  components: { InputName },
  data() {
    return {
      importedName: "",
    };
  },

  methods: {
    nameChangedHandler(e) {
      this.importedName = e.name;
    },
  },
};
</script>

<template>
  <div>
    <InputName @nameChanged="nameChangedHandler" />
    <hr />
    <h3>App 데이터 : {{ importedName }}</h3>
  </div>
</template>
