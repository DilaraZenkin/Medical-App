<template>
  <v-app id="inspire">
    <v-content class="main">
      <v-container fluid>
        <v-layout justify-center align-center>
          <v-flex xs>
            <v-card
             v-bind:key="availability.id"
            v-for="availability in availabilities">
              <v-card-text>
                <div>Date: </div>
                <p class="text-h6 text--primary">{{availability.dayOfWeek}}</p>
                <div class="text--primary">
                From: {{availability.startTime}}
                </div>
                <div class="text--primary">
                 To: {{availability.endTime}}
                  
                </div>
              </v-card-text>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
    <div id="app">
  <v-app id="inspire">
    <div class="text-center">
      <v-btn
        rounded
        color="primary"
        dark
        :to="{name: 'doctor-list'}"
      >
        Add Availability
      </v-btn>
    </div>
  </v-app>
</div>
  </v-app>
</template>

<script>
import AvailabilityService from '../services/AvailabilityService'
export default {
  name: "doctor-availability",
  data: () => ({
    enable: false,
    patient: {},
    doctor: {},
    availabilities: []
  }),
  created() {
      AvailabilityService.getAvailability(this.$store.state.user.id).then(
        (response) => {
          this.availabilities = response.data;
        }
      );
  },
  methods: {
    resetForm() {
      this.showForm = false;
    },
    updatePatient() {},
  },
};
</script>

<style>
</style>