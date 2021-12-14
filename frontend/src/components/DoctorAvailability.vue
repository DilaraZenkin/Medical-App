<template>
  <v-app id="inspire">
    <v-content class="main">
      <v-container fluid>
        <v-layout justify-center align-center>
          <v-flex xs>
            <v-card
              :loading="loading"
              v-bind:key="availability.id"
              v-for="availability in availabilities"
            >
              <template slot="progress">
                <v-progress-linear
                  color="deep-purple"
                  height="10"
                  indeterminate
                ></v-progress-linear>
              </template>
              <v-toolbar dark color="#1A5276">
                <v-card-title>{{ availability.dayOfWeek }}</v-card-title >
              </v-toolbar>
              <v-divider class="mx-4"></v-divider>
              <v-card-title>Availability</v-card-title>
              <v-card-text>
                <v-chip-group
                  v-model="selection"
                  active-class="deep-purple accent-4 white--text"
                  column
                >
                  <v-chip>5:30PM</v-chip>
                  <v-chip>7:30PM</v-chip>
                  <v-chip>8:00PM</v-chip>
                  <v-chip>9:00PM</v-chip>
                </v-chip-group>
              </v-card-text>
              <v-card-actions>
               <v-btn color="#1A5276" dark @click="updateAvailability">
                  Change Availability
                </v-btn> 
              </v-card-actions>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import AvailabilityService from '../services/AvailabilityService'
export default {
    name: 'doctor-availability',
    data: () => ({
        loading: false,
        selection: 1,
        availabilities: [],
    }),
    created() {
        AvailabilityService.getAvailability(this.$store.state.user.id).then(response => {
            this.availabilities = response.data;
            this.loading = false;
        })
    }
}
</script>
<style>

</style>