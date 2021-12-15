<template>
  <v-app id="inspire">
    <v-app-bar app color="#1A5276" dark flat>
      <v-container class="py-0 fill-height">
        <v-btn v-for="link in links" :key="link" text>
          {{ link }}
        </v-btn>
        <v-spacer></v-spacer>
      </v-container>
      <v-container v-if="this.$store.state.token != ''" class="text-right">
        <v-avatar color="grey darken-1" size="32"></v-avatar>
        <v-btn icon class="ma-2" id="home-logout" :to="{ name: 'logout' }">
          <v-icon left x-large> logout </v-icon>
        </v-btn>
      </v-container>
    </v-app-bar>
    <v-main class="grey lighten-3">
      <v-container height="200">
        <v-row>
          <v-col cols="2">
            <v-card class="mx-left" height="100%" width="256">
              <v-navigation-drawer color="#85929E" dark permanent>
                <v-list>
                  <v-list-item
                    v-for="item in menuItems"
                    :key="item.title"
                    link
                    :to="{ name: item.id }"
                  >
                    <v-list-item-icon>
                      <v-icon>{{ item.icon }}</v-icon>
                    </v-list-item-icon>

                    <v-list-item-content>
                      <v-list-item-title>{{ item.title }}</v-list-item-title>
                    </v-list-item-content>
                  </v-list-item>
                </v-list>
              </v-navigation-drawer>
            </v-card>
          </v-col>
          <v-col>
            <v-sheet min-height="90vh" rounded="lg">
              <router-view />
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: "App",
  data: () => ({
    links: ["Dashboard", "Messages", "Profile",  "Updates"],
  }),
  computed: {
    menuItems() {
      if (this.$store.state.token != "") {
        if (this.$store.state.user.authorities[0].name === "ROLE_USER") {
          return [
            {
              id: "patient-information",
              title: "Profile",
              icon: "person",
            },
            {
              id: "patient-appointments",
              title: "Appointments",
              icon: "tour",
            },
            { id: "doctor-list", title: "Doctors", icon: "medication" },
            { id: "locations", title: "Locations", icon: "business_center" },


          ];
        } else {
          return [
                  {
              id: "doctor-appointments",
              title: "Appointments",
              icon: "tour",
            },
            {
              id: "doctor-availability",
              title: "Set Availability",
              icon: "person",
            },
                        {
              id: "doctor-office",
              title: "View Office Information",
              icon: "business_center",
            },
          ];
        }
      }

      return [
        { id: "office-list", title: "Offices", icon: "business_center" },
        { id: "doctor-list", title: "Doctors", icon: "medication" },
      ];
    },
  },
};
</script>
<style>
.v-list-item--active {
  background-color: #1a5276;
}
</style>
