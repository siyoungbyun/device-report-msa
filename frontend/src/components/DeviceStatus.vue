<template>
    <div>
        <v-card-title>
            DeviceStatus
        </v-card-title>
        <v-card-text>
            <div v-if="editMode">
                <v-select
                        v-model="newValue"
                        :label="'name'"
                        :items="deviceStatusList"
                ></v-select>
            </div>
            <div v-else>
                DeviceStatus : {{ value }}
            </div>
        </v-card-text>
    </div>
</template>

<script>
    export default {
        name: 'DeviceStatus',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
            deviceStatusList : [ "ACTIVATED",  "DEACTIVATED", ],
            newValue: '',
        }),
        async created() {
            if(!this.value) {
                this.newValue = this.deviceStatusList[0];
            } else {
                this.newValue = this.value;
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },
        methods: {
        }
    }
</script>

