<template>
  <div id="app">
    <v-container class="text-right">
      <v-btn id="home-login" :to="{name: 'doctor-home'}">Home</v-btn>
      <v-btn id="home-logout" :to="{name: 'logout'}">Logout</v-btn>
    </v-container> 
    <v-app id="inspire">
    <v-card
      class="mx-auto"
      max-width="344"
    >
      <v-img
        src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
        height="200px"
      ></v-img>
  
      <v-card-title>
        {{offices.getSpecificOffice}}
      </v-card-title>
  
      <v-card-subtitle>
        1,000 miles of wonder
      </v-card-subtitle>
  
      <v-card-actions>
        <v-btn
          color="orange lighten-2"
          text
        >
          Explore
        </v-btn>
  
        <v-spacer></v-spacer>
  
        <v-btn
          icon
          @click="show = !show"
        >
          <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
        </v-btn>
      </v-card-actions>
  
      <v-expand-transition>
        <div v-show="show">
          <v-divider></v-divider>
  
          <v-card-text>
            I'm a thing. But, like most politicians, he promised more than he could deliver. You won't have time for sleeping, soldier, not with all the bed making you'll be doing. Then we'll go with that data file! Hey, you add a one and two zeros to that or we walk! You're going to do his laundry? I've got to find a way to escape.
          </v-card-text>
        </div>
      </v-expand-transition>
    </v-card>
  </v-app>
</div>
</template>
<script>
import officeService from '../services/OfficeService'
export default {
  name:"doctor-office",
   data: () => ({
    loading: false,
    selection: 1,
    offices: []
  }),
  created() {
    officeService.getSpecificOffice().then(response => {
      this.office = response.data;
      this.isLoading = false;
    });
  },
  methods: {
    reserve() {
      this.loading = true;
      setTimeout(() => (this.loading = false), 2000);
    },
  },
};
</script>
