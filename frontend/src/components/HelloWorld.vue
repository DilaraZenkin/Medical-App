<template>
  <v-container>
    <v-container class="text-right">
      <v-btn id="home-login" :to="{name: 'login'}">Login</v-btn>
      <v-btn id="home-logout" :to="{name: 'logout'}">Logout</v-btn>
    </v-container>  
    

<div id="app">
  <v-app id="inspire">
    <v-container fluid>
      <v-row justify="space-around">
        <v-col cols="5">


          <v-img
            src="../logo/logo.png"
            aspect-ratio="0.75"
          ></v-img>
             </v-col>
      </v-row>
    </v-container>
  </v-app>
</div>
</v-container> 