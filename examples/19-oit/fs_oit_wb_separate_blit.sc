$input v_texcoord0

/*
 * Copyright 2011-2025 Branimir Karadzic. All rights reserved.
 * License: https://github.com/bkaradzic/bgfx/blob/master/LICENSE
 */

#include "../common/common.sh"

SAMPLER2D(s_texColor0, 0);
SAMPLER2D(s_texColor1, 1);

void main()
{
	vec4  accum   = texture2D(s_texColor0, v_texcoord0);
	float opacity = accum.w;
	float weight  = texture2D(s_texColor1, v_texcoord0).x;
	gl_FragColor = vec4(accum.xyz / clamp(weight, 1e-4, 5e4), opacity);
}
