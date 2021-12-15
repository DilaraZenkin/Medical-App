<template>
  <v-app id="inspire">
    <v-content class="main">
      <v-container fluid>
        <v-layout justify-center align-center>
          <v-flex xs>
            <v-card 
            v-bind:key="office.id"
            v-for="office in offices">
              <v-toolbar dark color="#1A5276">
                <v-toolbar-title>{{office.officeName}}</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
                <div>Practice locations</div>
                <p class="text-h4 text--primary">{{office.address}}</p>
                <p>Contact: {{office.officePhoneNumber}}</p>
                <div class="text--primary">
                 Open: {{office.officeOpen}} 
                </div>
                <div class="text--primary">
                 Close: {{office.officeClose}}
                  
                </div>
              </v-card-text>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import locationService from "../services/LocationService";
export default {
  name: "locations",
 data: () => ({
    loading: false,
    selection: 1,
    offices: [],
  }),
  created() {
    locationService.getOffices().then((response) => {
      this.offices = response.data;
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

<style>
</style>