import { createSlice } from "@reduxjs/toolkit";


interface AuthState {
	token: string | null;
}

/**
 * Slice for authentication.
 */
const authSlice = createSlice({
	name: "auth",
	initialState: { token: null } as AuthState,
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
export const selectCurrentToken = (state: unknown & { auth: AuthState }) => state.auth.token as keyof AuthState;
export default authSlice.reducer;
