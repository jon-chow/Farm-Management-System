import { createSlice } from "@reduxjs/toolkit";

/**
 * Slice for authentication.
 */
const authSlice = createSlice({
	name: "auth",
	initialState: { token: null },
	reducers: {
		setCredentials: (state, action) => {
			const { accessToken } = action.payload;
			state.token = accessToken as string;
		},
		logOut: (state, action?) => {
			state.token = null;
		},
	},
});

export const { setCredentials, logOut } = authSlice.actions;
export const selectCurrentToken = (state: any) => state.auth.token;
export default authSlice.reducer;
