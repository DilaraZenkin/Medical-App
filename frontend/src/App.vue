<template>
  <v-app>
    <v-system-bar app>
      <v-spacer></v-spacer>
      <v-icon>mdi-square</v-icon>
      <v-icon>mdi-circle</v-icon>
      <v-icon>mdi-triangle</v-icon>
    </v-system-bar>
    <v-app-bar app>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
        <v-divider
        class="mx-4"
        vertical
      ></v-divider>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </v-toolbar-title>
    </v-app-bar>
    <v-navigation-drawer
      v-model="drawer"
      fixed
      temporary
    >
      <!--  -->
    </v-navigation-drawer>

    <v-main  class="main grey lighten-2">
      <v-container>
        <router-view />
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
  export default {
    data: () => ({ drawer: null }),
  }
</script>

<style scoped>
  .main {
    padding-top: 8px;
  }
</style>