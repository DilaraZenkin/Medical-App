<template>
  <v-app id="inspire">
    <v-content class="main">
      <v-container fluid>
        <v-layout justify-center align-center>
          <v-flex xs>
            <v-card>
              <v-toolbar dark color="#1A5276">
                <v-toolbar-title>New Availability</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
                <v-form @submit.prevent="register">
                 <v-menu
                v-model="availabilityDateMenu"
                :close-on-content-click="false"
                :nudge-right="40"
                transition="scale-transition"
                offset-y 
                max-width="290px"
                min-width="290px"
            >
                <template v-slot:activator="{ on }">
                <v-text-field
                    label="Availability Date"
                    prepend-icon="event"
                    readonly
                    v-on="on"
                    id="availabilityDate"
                    class="doctorInfo"
                    v-model="availability.dayOfWeek"
                    outlined
                    autofocus
                ></v-text-field>
                </template>
                <v-date-picker
                locale="en-in"
                v-model="availability.dayOfWeek"
                no-title
                @input="availabilityDateMenu = false"
                ></v-date-picker>
                </v-menu>
                <v-chip-group
                    id="start"
                    prepend-icon=""
                    class="updateAvailability"
                    label="Start Time"
                    v-model="availability.startTime"
                    active-class="deep-purple accent-4 white--text"
                    >
                    Start Time:
                    <v-spacer />
                      <v-chip>8:00AM</v-chip>
                      <v-chip>8:30AM</v-chip>
                      <v-chip>9:00AM</v-chip>
                      <v-chip>9:30AM</v-chip>
                      <v-chip>10:00AM</v-chip>
                      <v-chip>10:30AM</v-chip>
                      <v-chip>11:00AM</v-chip>
                    </v-chip-group>
                    <v-chip-group
                    id="end"
                    prepend-icon=""
                    class="updateAvailability"
                    label="End Time"
                    v-model="availability.endTime"
                    active-class="deep-purple accent-4 white--text"
                    >
                    End Time:
                    <v-spacer />
                      <v-chip>1:00PM</v-chip>
                      <v-chip>1:30PM</v-chip>
                      <v-chip>2:00PM</v-chip>
                      <v-chip>2:30pm</v-chip>
                      <v-chip>3:00PM</v-chip>
                      <v-chip>3:30PM</v-chip>
                      <v-chip>4:00PM</v-chip>
                    </v-chip-group>
                <v-checkbox
                id="available"
                    prepend-icon=""
                    class="availability"
                    label="Available?"
                    v-model="availability.available"
                ></v-checkbox>
                <v-btn color="primary" type="submit" @submit.prevent="updateAvailability()">Update Availability</v-btn>
                <v-btn color="pink" type="reset" @:reset.prevent="cancelUpdate()" :to="{name: 'doctor-availability'}">Cancel Update</v-btn>
                </v-form>
              </v-card-text>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>
<script>
import AvailabilityService from '../services/AvailabilityService';
export default {
  name: "new-availability",
  data: () => ({
    enable: false,
    patient: {},
    doctor: {},
    availability: {
        availabilityId: '',
        doctorId: '',
        dayOfWeek: '',
        startTime: '',
        endTime: '',
        available: '',

    }
  }),
  created() {
  },
  methods: {
    resetForm() {
      this.showForm = false;
      this.availability = {}
    },
    addAvailability() {
      this.availability.doctorId = this.$store.state.user.id;
        AvailabilityService.addAvailability(this.availability).then(response => {
            if (response.statue == 201) {
                this.$router.push({name: 'doctor-availability'})
            }
        })
    },
  },
};
</script>
<style>
</style>